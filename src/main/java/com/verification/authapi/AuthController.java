package com.verification.authapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/check")
public class AuthController {
    @PostMapping
    public ResponseEntity<String> checkCredentials(@RequestBody AuthRequest request) {

        HashMap<String, String> usernameList = new HashMap<>();
        usernameList.put("Dorel", "bestlol");
        for (Map.Entry<String, String> entry : usernameList.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();

            if (username.equals(request.getUsername()) && password.equals(request.getPassword()))
                return ResponseEntity.ok("Successfully Logged In");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
