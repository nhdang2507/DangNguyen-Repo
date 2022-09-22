import axiosClient from "../utils/axios-client";

const apiRequestHelper = {
  getPhotos: async (page, perPage) => {
    return await axiosClient.get(`/photos`, { params: { page, perPage } });
  },
};

export default apiRequestHelper;
