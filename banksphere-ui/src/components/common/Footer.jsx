const Footer = () => {
  return (
    <footer className="bg-[#0A2540] text-white py-5">
      <div className="max-w-7xl mx-auto px-8 flex justify-between items-center">

        <p className="text-sm">
          © 2026 BankSphere. All Rights Reserved.
        </p>

        <div className="flex gap-8 text-sm">
          <a href="#" className="hover:text-blue-300">
            Privacy Policy
          </a>

          <a href="#" className="hover:text-blue-300">
            Terms & Conditions
          </a>

          <a href="#" className="hover:text-blue-300">
            Contact Us
          </a>
        </div>

      </div>
    </footer>
  );
};

export default Footer;