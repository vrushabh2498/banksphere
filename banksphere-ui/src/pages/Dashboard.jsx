import Header from "../components/common/Header";
import Footer from "../components/common/Footer";

const Dashboard = () => {
  return (
    <div className="min-h-screen flex flex-col bg-slate-100">

      <Header />

      <main className="flex-grow max-w-7xl mx-auto w-full p-8">

        <div className="mb-8">

          <h1 className="text-4xl font-bold text-slate-800">
            Dashboard
          </h1>

          <p className="text-slate-500 mt-2">
            Welcome to BankSphere Banking Platform
          </p>

        </div>

        <div className="grid md:grid-cols-3 gap-6">

          <div className="bg-white p-6 rounded-2xl shadow-lg hover:shadow-xl transition duration-300">
            <h2 className="text-xl font-semibold text-slate-700">
              Total Accounts
            </h2>

            <p className="text-5xl font-bold text-blue-600 mt-4">
              125
            </p>
          </div>

          <div className="bg-white p-6 rounded-2xl shadow-lg hover:shadow-xl transition duration-300">
            <h2 className="text-xl font-semibold text-slate-700">
              Transactions
            </h2>

            <p className="text-5xl font-bold text-green-600 mt-4">
              850
            </p>
          </div>

          <div className="bg-white p-6 rounded-2xl shadow-lg hover:shadow-xl transition duration-300">
            <h2 className="text-xl font-semibold text-slate-700">
              Customers
            </h2>

            <p className="text-5xl font-bold text-purple-600 mt-4">
              420
            </p>
          </div>

        </div>

      </main>

      <Footer />

    </div>
  );
};

export default Dashboard;