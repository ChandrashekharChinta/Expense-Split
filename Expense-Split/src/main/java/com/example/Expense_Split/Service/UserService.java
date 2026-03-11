package com.example.Expense_Split.Service;

import com.example.Expense_Split.DTO.BalanceResponseDTO;
import com.example.Expense_Split.DTO.UserRequestDTO;
import com.example.Expense_Split.DTO.UserResponseDTO;
import com.example.Expense_Split.Entity.Split;
import com.example.Expense_Split.Entity.SplitStatus;
import com.example.Expense_Split.Entity.User;
import com.example.Expense_Split.Exception.InvalidOperationException;
import com.example.Expense_Split.Exception.UserNotFoundException;
import com.example.Expense_Split.Repository.SplitRepository;
import com.example.Expense_Split.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SplitRepository splitRepository;

    public UserService(UserRepository userRepository,
                       SplitRepository splitRepository) {
        this.userRepository = userRepository;
        this.splitRepository = splitRepository;
    }

    // 1️ Create User
    public UserResponseDTO createUser(UserRequestDTO request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User savedUser = userRepository.save(user);

        return mapToDTO(savedUser);
    }

    // 2️ Get User By Id
    public UserResponseDTO getUser(int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id));

        return mapToDTO(user);
    }

    // 3️ Add Friend
    public String addFriend(int userId, int friendId) {

        if (userId == friendId) {
            throw new InvalidOperationException("User cannot add themselves as friend");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + userId));

        User friend = userRepository.findById(friendId)
                .orElseThrow(() ->
                        new UserNotFoundException("Friend not found with id: " + friendId));

        if (!user.getFriends().contains(friend)) {
            user.getFriends().add(friend);
            friend.getFriends().add(user);

            userRepository.save(user);
            userRepository.save(friend);
        }

        return "Friend added successfully";
    }

    // 4️ Get All Users
    public List<UserResponseDTO> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // 5️ Delete User
    public String deleteUser(int id) {

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    // 6️ Balance Calculation Logic
    public BalanceResponseDTO getBalance(int userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        List<Split> youOweSplits =
                splitRepository.findByFromUserIdAndStatus(userId, SplitStatus.UNPAID);

        List<Split> youAreOwedSplits =
                splitRepository.findByToUserIdAndStatus(userId, SplitStatus.UNPAID);

        double totalYouOwe = youOweSplits.stream()
                .mapToDouble(Split::getAmount)
                .sum();

        double totalYouAreOwed = youAreOwedSplits.stream()
                .mapToDouble(Split::getAmount)
                .sum();

        double netBalance = totalYouAreOwed - totalYouOwe;

        Map<String, Double> breakdown = new HashMap<>();

        for (Split split : youOweSplits) {
            breakdown.merge(
                    "You owe " + split.getToUser().getName(),
                    split.getAmount(),
                    Double::sum
            );
        }

        for (Split split : youAreOwedSplits) {
            breakdown.merge(
                    split.getFromUser().getName() + " owes you",
                    split.getAmount(),
                    Double::sum
            );
        }

        return new BalanceResponseDTO(
                totalYouOwe,
                totalYouAreOwed,
                netBalance,
                breakdown
        );
    }

    // 🔁 Mapper
    private UserResponseDTO mapToDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
