package kr.re.kepri.pcm.main.vo;

/**
 * packageName    : kr.re.kepri.pcm.main.vo
 * fileName       : CalculationVO
 * author         : dj
 * date           : 4/8/2025
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 4/8/2025        dj       최초 생성
 */
public class CalculationVO {
     private String officeCd;   // 사업소코드
    private String searchYm;   // 조회년월

    public String getOfficeCd() {
        return officeCd;
    }

    public void setOfficeCd(String officeCd) {
        this.officeCd = officeCd;
    }

    public String getSearchYm() {
        return searchYm;
    }

    public void setSearchYm(String searchYm) {
        this.searchYm = searchYm;
    }
}
