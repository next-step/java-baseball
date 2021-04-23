package baseball.config;

import baseball.constants.MessageKey;
import baseball.model.BaseballNumber;
import lombok.Getter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

@Getter
public class BaseballConfig {
    private static final String MESSAGE_BUNDLE_NAME = "message";
    private int size;
    private int radix;
    private int tryCount;
    private Locale locale;
    private ResourceBundle resourceBundle;

    private BaseballConfig() {
    }

    public static class Builder {
        private BaseballConfig config;

        public Builder() {
            this.config = new BaseballConfig();
            this.config.size = BaseballNumber.DEFAULT_NUMBERS_SIZE;
            this.config.radix = BaseballNumber.DEFAULT_NUMBER_RADIX;
            this.config.tryCount = 0;
        }

        public Builder size(int size) {
            this.config.size = size;
            return this;
        }

        public Builder radix(int radix) {
            this.config.radix = radix;
            return this;
        }

        public Builder tryCount(int tryCount) {
            this.config.tryCount = tryCount;
            return this;
        }

        public Builder locale(Locale locale) {
            this.config.locale = locale;
            this.config.resourceBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_NAME, locale);
            return this;
        }

        public BaseballConfig build() {
            if (this.config.resourceBundle == null) {
                this.config.locale = Locale.getDefault();
                this.config.resourceBundle = ResourceBundle.getBundle("message", this.config.locale);
            }

            return this.config;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getMessage(String key) {
        return this.convertEncoding(this.resourceBundle.getString(key));
    }

    public String getMessage(MessageKey key) {
        return this.getMessage(key.toString());
    }

    private String convertEncoding(String input) {
        return this.convertEncoding(input, StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8);
    }

    private String convertEncoding(String input, Charset from, Charset to) {
        return new String(input.getBytes(from), to);
    }

}
