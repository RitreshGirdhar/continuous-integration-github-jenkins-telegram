#  Github Jenkins Webhooks integration - Send notification to telegram via Jenkins
For every commit or MR merged to master branch Github webhook will generate event to Jenkins job which will build + test master branch 
and push notification through telegram

### Pre-requisite 
* You should have basic knowledge of docker + jenkins + git + declarative pipeline


## Set up Jenkins
```
docker run -d -p8080:8080 jenkins/jenkins
```

## Github Jenkins WebHooks integration

* Goto Github Account -> Setting -> Personal Access Token. Choose repo, admin.repo options and generate token. Do copy the token.
![personal token generation options](images/personal-token-generation-options.png)

* Configure Github personal token in Jenkins Configuration Before that Goto Jenkins -> Credentials -> Global Credentials -> Add credentials -> Select Secret text option and copy the token 
![github token](images/github-token.png)

* Now goto Manage Jenkins -> Configure System -> Add github server and Configure github account and select the credential which you created in above step.
![add github server details ](images/add-github-server.png)

* Now Let's set up Github Webhook. Goto Github Repo -> Setting -> Webhook -> Add Webhook. Fill the jenkins server url with respective format plus do select the type of push event
![webhook details](images/webhook-details.png)

* Once webhook is integrated you will see green tick sign as a successful integration.
![Github webhook integrated successfully](images/github-webhook-added-success.png)
  
  
* Now lets create a sample jenkins job. Goto jenkins server, create any kind of job. For this demo i am creating free style project.

* Configure the jenkins job and provide Git server details plus do select option `GitHub hook trigger for GITScm polling option.`
![Jenkins job configuration](images/jenkins-job-configuration.png)

* Now let's test the integration by Pushing some code changes in master branch. Once its done check the invoked Jenkins job console.
![Jenkins job initiated](images/jenkins-job-initiated.png)
![Jenkins job console output](images/jenkins-job-success-details.png)

 
## Telegram Bot Set up
* WIP 
*
*

## Jenkins Telegram integration