pipeline {
   agent any
   parameters {
           gitParameter defaultValue: 'origin/master', name: 'SBRANCH', type: 'PT_BRANCH_TAG',quickFilterEnabled:true ,description: 'Select Branch'
           booleanParam(name: 'CHECKOUT', defaultValue: 'false', description: 'CHECKOUT')
           booleanParam(name: 'BUILD', defaultValue: 'false', description: 'BUILD')
           booleanParam(name: 'SONAR', defaultValue: 'false', description: 'SONAR')
           booleanParam(name: 'PUSH_REGISTRY', defaultValue: 'false', description: 'PUSH_REGISTRY')
           booleanParam(name: 'DEPLOY', defaultValue: 'false', description: 'DEPLOY')
           string(name: 'REGISTRY_REPOSITORY', defaultValue: 'speedy', description: 'REGISTRY_REPOSITORY')
           string(name: 'verticalIds', defaultValue: 'fs', description: 'verticalIds')
   }
   stages {
      stage('Build') {
      
      }
      stage('Push Notification') {
       steps {
            script{
             withCredentials([string(credentialsId: 'telegramToken', variable: 'TOKEN'),
                string(credentialsId: 'telegramChatId', variable: 'CHAT_ID')]) {
                   sh """
                  curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage -d chat_id=${CHAT_ID} -d parse_mode="HTML" -d text="<b>Project</b> : POC \
                   <b>Branch</b>: master \
                   <b>Build </b> : OK \
                   <b>Test suite</b> = Passed"
                   """
                }
            }
        }
     }
   }
}
