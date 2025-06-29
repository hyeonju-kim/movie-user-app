//package com.clean.user_app.common.dto;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotNull;
//import lombok.Data;
//
///**
// * description    : 페이징 처리 클래스
// * packageName    : com.clean.user_app.common.dto
// * fileName       : BaseDto
// * author         : 김현주
// * date           : 25. 6. 14.
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 25. 6. 14.        김현주             최초 생성
// */
//
//
//@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class BaseDto {
//    @JsonProperty("pNum")
//    @NotNull(message = "페이지 번호는 필수입니다.")
//    @Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다.")
//    public Integer pNum = 1;
//    @JsonProperty("pSize")
//    @NotNull(message = "페이지 크기는 필수입니다.")
//    @Min(value = 1, message = "페이지 크기는 1 이상이어야 합니다.")
//    public Integer pSize = 10;
//    @JsonProperty("pIndex")
//    @JsonIgnore
//    public Integer pIndex;
//    @JsonProperty("keyword")
//    public String keyword;
//
//    /* ========================= Getter / Setter ========================= */
//    public Integer getpIndex() {
//        if (this.pNum != null && this.pSize != null)
//            return (this.pNum - 1) * this.pSize;
//
//        return pIndex;
//    }
//}
