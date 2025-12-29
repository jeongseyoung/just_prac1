package com.example.mybatiscrudprac.domain.resultset;



import com.example.mybatiscrudprac.domain.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListItem {
    

    private long userId;
    private String userName;
    private String userEmail;
    private String status;

    public UserListItem(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.userName = userDto.getUserName();
        this.userEmail = userDto.getUserEmail();
        this.status = userDto.getStatus();
    }

    // public List<UserListItem> createUserListDto(List<UserDto> list) {
    //     List<UserListItem> temp_list = new ArrayList<>();
    //     for(UserDto user : list) {
    //         temp_list.add(new UserListItem(user));
    //     }
    //     return temp_list;
    // }
}
