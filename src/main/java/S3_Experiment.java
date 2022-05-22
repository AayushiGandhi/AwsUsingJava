import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.io.File;

public class S3_Experiment {
    public AmazonS3 getConnection(){
        BasicSessionCredentials sessionCredentials = new BasicSessionCredentials(
                Constant.aws_access_key_id,
                Constant.aws_secret_access_key,
                Constant.aws_session_token);

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(sessionCredentials))
                .withRegion(Regions.US_WEST_2)
                .build();

        return s3client;
    }

    public String createS3Bucket(String bucketName){
        AmazonS3 s3client = getConnection();

        if(s3client.doesBucketExist(bucketName)) {
            return "Bucket already exists";
        }

        Bucket bucket = s3client.createBucket(bucketName);
        System.out.println("Bucket details: " + bucket);
        return "Bucket created successfully";
    }

    public String uploadFileToS3Bucket(String bucketName){
        AmazonS3 s3client = getConnection();

        try{
            s3client.putObject(
                    bucketName,
                    "Aayushi.txt",
                    new File("Aayushi.txt")
            );
            return "File uploaded successfully";
        }
        catch (Exception e){
            return "Error while uploading the file";
        }
    }
}
