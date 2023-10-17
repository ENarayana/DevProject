package test.api.devproject.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetProductRequestDto {
    private List<Long> id;
}
