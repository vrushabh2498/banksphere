import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../services/authService";
import Header from "../components/common/Header";
import Footer from "../components/common/Footer";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const handleLogin = async () => {
    
    try {
      const loginData = {
        email,
        password,
      };

      const handleLogout = () => {

  localStorage.removeItem("token");

  navigate("/");

};

      const response = await login(loginData);

      console.log(response);

      localStorage.setItem("token", response.token);

      navigate("/dashboard");

    } catch (error) {
      console.error(error);
      alert("Login Failed");
    }
    
  };

  return (
    <div className="min-h-screen flex flex-col bg-gradient-to-br from-slate-50 to-blue-100">
      <Header />

      <main className="flex-grow flex items-center">
        <div className="max-w-7xl mx-auto px-8 py-16 w-full">
          <div className="grid lg:grid-cols-2 gap-16 items-center">


            <div>
              <h1 className="text-6xl font-bold text-slate-800 mb-6 leading-tight">
                Secure Banking Platform
              </h1>

              <p className="text-xl text-slate-600 mb-10">
                Trusted Digital Banking Solution for secure and real-time
                financial services.
              </p>

              <div className="space-y-5 text-slate-700 text-lg">
                <div>✔ Account Management</div>
                <div>✔ Transaction Processing</div>
                <div>✔ Digital Payments</div>
                <div>✔ Secure Authentication</div>
                <div>✔ Real-Time Banking</div>
                <div>✔ Microservice Architecture</div>
              </div>
            </div>

            {/* Login Card */}

            <div className="bg-white p-10 rounded-3xl shadow-2xl border border-slate-100">
              <h2 className="text-4xl font-bold text-center mb-10 text-slate-800">
                Welcome Back
              </h2>

              <div className="space-y-6">

                <input
                  type="email"
                  placeholder="Enter Email Address"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  className="w-full px-5 py-4 rounded-xl border border-slate-300 focus:outline-none focus:ring-2 focus:ring-blue-500"
                />

                <input
                  type="password"
                  placeholder="Enter Password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  className="w-full px-5 py-4 rounded-xl border border-slate-300 focus:outline-none focus:ring-2 focus:ring-blue-500"
                />

                <div className="text-right">
                  <a
                    href="#"
                    className="text-blue-600 hover:text-blue-800 text-sm font-medium"
                  >
                    Forgot Password?
                  </a>
                </div>

                <button
                  onClick={handleLogin}
                  className="w-full bg-blue-600 hover:bg-blue-700 text-white py-4 rounded-xl font-semibold text-lg transition duration-300"
                >
                  Login
                </button>

              </div>
            </div>

          </div>
        </div>
      </main>

      <Footer />
    </div>
  );
};

export default Login;