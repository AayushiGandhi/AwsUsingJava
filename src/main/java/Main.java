public class Main {
    public static void main(String args[]){
        String bucketName = "demo-serverless-bucket-b00890697";
        S3_Experiment s3_experiment = new S3_Experiment();
        System.out.println(s3_experiment.createS3Bucket(bucketName));

        System.out.println(s3_experiment.uploadFileToS3Bucket(bucketName));
    }
}
