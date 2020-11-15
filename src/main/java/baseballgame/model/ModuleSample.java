package baseballgame.model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor()
public class ModuleSample {
    @NonNull
    private final int id;
    @NonNull
    private final String name;

    public String getInfo() {
        return id + name;
    }
}
