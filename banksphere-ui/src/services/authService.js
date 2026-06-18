import axiosClient from "../api/axiosConfig";

export const login = async (loginData) => {
  const response = await axiosClient.post(
    "/api/v1/auth/login",
    loginData
  );

  return response.data;
};