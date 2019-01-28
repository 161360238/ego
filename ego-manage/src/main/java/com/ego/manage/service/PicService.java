package com.ego.manage.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PicService {

	Map<String,Object> upload(MultipartFile file)throws IOException;
}
