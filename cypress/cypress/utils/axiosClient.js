import axios from "axios";
import qs from "qs";

const BASE_URL = "https://api.unsplash.com";
const ACCESS_TOKEN = "kueuthCi38-1hwhp71RIGtOi6hi2u3czJbVrKTf_jQ4";

const axiosClient = axios.create({
  baseURL: BASE_URL,
  paramsSerializer: (params) => {
    return qs.stringify(params, { skipNulls: true });
  },
});

axiosClient.interceptors.request.use(
  (config) => {
    config.headers.Authorization = `Bearer ${ACCESS_TOKEN}`;
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

export default axiosClient;
