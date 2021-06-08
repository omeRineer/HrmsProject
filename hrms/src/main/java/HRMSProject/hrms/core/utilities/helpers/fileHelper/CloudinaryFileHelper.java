package HRMSProject.hrms.core.utilities.helpers.fileHelper;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessResult;

@Service
public class CloudinaryFileHelper implements FileHelper {

	private Cloudinary cloudinary;
	
	public CloudinaryFileHelper() {
		cloudinary=new Cloudinary(ObjectUtils.asMap(
				"cloud_name","dgy8pzvvn",
				"api_key","731419646541968",
				"api_secret","7IgjJX_K3iRGoWNLjSAM2_oBUvc"
			));
	}
	
	@Override
	public Result upload(MultipartFile file){
		try {
			cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
			return new SuccessResult();
		} catch (Exception e) {
			return new ErrorResult();
		}
		
	}

}
