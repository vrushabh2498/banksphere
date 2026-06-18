import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";

const Header = () => {

  const navigate = useNavigate();

  const token = localStorage.getItem("token");

  let userEmail = "";
  let userRole = "";

  if (token) {
    const decodedToken = jwtDecode(token);

    userEmail = decodedToken.sub;
    userRole = decodedToken.role;
  }

  const handleLogout = () => {

    localStorage.removeItem("token");

    navigate("/");

  };

  return (
    <header className="bg-[#0A2540] shadow-lg">

      <div className="max-w-7xl mx-auto px-8 py-4 flex justify-between items-center">

        <div>
          <h1 className="text-3xl font-bold text-white">
            BankSphere
          </h1>

          <p className="text-sm text-slate-300">
            Secure Digital Banking
          </p>
        </div>

        <div className="flex items-center gap-10">

          <nav className="hidden md:flex gap-8 text-white font-medium">
            <a href="#">About</a>
            <a href="#">Services</a>
            <a href="#">Contact</a>
          </nav>

          {token && (
            <div className="flex items-center gap-3">

              <div className="w-12 h-12 rounded-full bg-blue-600 flex items-center justify-center text-white font-bold text-lg">
                BS
              </div>

              <div className="flex flex-col">

                <span className="text-white text-sm font-medium">
                  {userEmail}
                </span>

                <span className="text-slate-300 text-xs">
                  {userRole}
                </span>

                <button
                  onClick={handleLogout}
                  className="text-left text-red-300 text-xs hover:text-red-400"
                >
                  Logout
                </button>

              </div>

            </div>
          )}

        </div>

      </div>

    </header>
  );
};

export default Header;