package util;



import java.util.List;

public  class StateOfObjectRequest {


        private Object object;
        private List<?> list;
        private Boolean error = false;

        public List<?> getList() {
                return list;
        }

        public void setList(List<?> list) {
                this.list = list;
        }

        private String errorString;

        public Object getObject() {
                return object;
        }

        public void setObject(Object object) {
                this.object = object;
        }

        public Boolean getError() {
                return error;
        }

        public void setError(Boolean error) {
                this.error = error;
        }

        public String getErrorString() {
                return errorString;
        }

        public void setErrorString(String errorString) {
                this.errorString = errorString;
        }
}
