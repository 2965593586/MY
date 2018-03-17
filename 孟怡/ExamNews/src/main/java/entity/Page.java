package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mycom on 2018/2/28.
 */
public class Page<T> {
        private int totalPage;//总页数
        private int totalSize;//总记录数
        private int pageSize;//每页的记录数
        private int pageIndex;//页码

        public List<T> getLists() {
            return lists;
        }

        public void setLists(List<T> lists) {
            this.lists = lists;
        }

        private List<T> lists=new ArrayList<T>();
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTotalPage() {
            //如果总记录数除以每页显示的记录数能整除，那么总页数等于商，否则商+1
            int total = (Integer) (totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1);

            //int total=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
            //return total;

            return total;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

}
