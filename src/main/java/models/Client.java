package models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
public class Client {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

}
