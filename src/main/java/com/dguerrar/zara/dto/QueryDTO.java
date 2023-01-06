package com.dguerrar.zara.dto;

import com.dguerrar.zara.generic.GenericObjectDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Schema(example = "{\"brandId\":\"1\",\"productId\":\"1\",\"date\":\"2022/01/01 10:00:00\"}")
public class QueryDTO extends GenericObjectDTO {

    private Long brandId;

    private Long productId;

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private LocalDateTime date;

}
