import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class S3_Experiment {
    public Bucket createS3Bucket(){
        AWSCredentials credentials = new BasicAWSCredentials(
                Constant.aws_access_key_id,
                Constant.aws_secret_access_key
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        String bucketName = "demo-serverless-bucket-b00890697";

        if(s3client.doesBucketExist(bucketName)) {
            System.out.println("Bucket name is not available." + " Try again with a different Bucket name.");
            return null;
        }

        Bucket bucket = s3client.createBucket(bucketName);
        return bucket;
    }

    public void uploadFileToS3Bucket(){

    }
}
