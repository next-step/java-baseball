package com.study.presentation.request;

import com.study.application.model.InputModel;

import java.io.BufferedReader;
import java.io.IOException;

import static com.study.domain.BaseballGameConstants.NUMBER_LENGTH;

/**
 * @author Jaedoo Lee
 */
public class InputRequest {
    private BufferedReader br;

    public InputRequest(BufferedReader br) {
        this.br = br;
    }

    public InputModel toModel() throws IOException {
        return new InputModel(checkInput(br), br);
    }

    private int checkInput(BufferedReader br) {
        int input = 0;
        try {
            input = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e) {
            System.exit(0);
        }

        validateInputLength(input);

        return input;
    }

    private void validateInputLength(int input) {
        if ((int)(Math.log10(input) + 1) > NUMBER_LENGTH) System.exit(0);
    }
}
