package com.ganeshgc.mobile_project.payload;

import com.ganeshgc.mobile_project.Dto.MobileVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MobileResponse {
    private List<MobileVo> content;
    private int pageNo;
    private int pageSize;
    private long totalCount;
    private int totalPage;
    private boolean isLastPage;

}
