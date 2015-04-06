package jp.entropia.sirens.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

@Service
public class S3Service {

	@Autowired
	private AmazonS3 amazonS3;

	public Upload uploadImage(String fileName, File file) {
		TransferManager transferManager = new TransferManager(this.amazonS3);
		return transferManager.upload("band.sirens", "event/" + fileName, file);
	}
}
