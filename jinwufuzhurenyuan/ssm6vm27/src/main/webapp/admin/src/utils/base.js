const base = {
    get() {
                return {
            url : "http://localhost:8080/ssm6vm27/",
            name: "ssm6vm27",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm6vm27/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "警务辅助人员管理系统小程序"
        } 
    }
}
export default base
