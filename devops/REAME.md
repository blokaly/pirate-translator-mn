## Create S3

```shell
$ aws s3api create-bucket --bucket=blokaly-terraform-piratemessage --region=ap-east-1 --create-bucket-configuration LocationConstraint=ap-east-1
```

## Build shadow jar

```shell
$ ./gradlew shadowJar
```

## Copy jar file to S3

```shell
$ aws s3 cp ./build/libs/app-0.1-all.jar s3://blokaly-terraform-piratemessage/v0.1/app.jar
```

## Reference

https://learn.hashicorp.com/tutorials/terraform/lambda-api-gateway