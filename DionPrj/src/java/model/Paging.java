package model;

public class Paging {

    public Paging() {
    }

    private int n;// tổng số bản ghi
    private int nrpp; //bản ghi mỗi page
    private int index;  // page hiện tại

    public Paging(int n, int nrpp, int index) {
        this.n = n;
        this.nrpp = nrpp;
        this.index = index;
    }

    public void calculate() {
//        if(n%nrpp == 0){
//            totalPage = n/nrpp;
//        }else{
//            totalPage = n/nrpp +1;    
//        }//c1
//        totalPage = n/nrpp+n%nrpp == 0?0:1;//c2

//        tùy thuộc vào mỗi trang có bao nhiêu data mà sinh ra bấy nhiêu page
        totalPage = (n + nrpp - 1) / nrpp;//c3
        
        index = index >= totalPage ? totalPage - 1 : index;
        index = index <= 0 ?index: index;
// index mới
        //trong cái mảng data đấy, hiển thị ra thông tin từ vị trí mấy đến vtri mấy
        begin = index * nrpp;
        end = begin + nrpp - 1;
        end = end >= n ? n - 1 : end;
        //
        pageStart = index - 2 < 0 ? 0 : index - 2;
        pageEnd = index + 2 >= totalPage ? totalPage - 1 : index + 2;
    }

    private int totalPage;
    private int begin;
    private int end;
    private int pageStart;
    private int pageEnd;

    public int getN() {
        return n;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNrpp() {
        return nrpp;
    }

    public void setNrpp(int nrpp) {
        this.nrpp = nrpp;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}
