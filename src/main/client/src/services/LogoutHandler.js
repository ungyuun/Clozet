function LogoutHandler(navigate){
    sessionStorage.clear();
    navigate("/");
}

export default LogoutHandler;