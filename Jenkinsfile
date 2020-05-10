pipeline {
   agent any
   stages {
     stage('Clean workspace') {
        steps {
               cleanWs()
        }
      }
      stage('Checkout') {
        steps {
               checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[url: 'https://github.com/RitreshGirdhar/continuous-integration-github-jenkins-telegram.git']], branches: [[name: 'origin/master']]], poll: false
        }
      }
      stage('Build') {
              steps {
                sh """
                       mvn clean install -P weather-service
                """
              }
      }
      stage('Test') {
                    steps {
                      sh """
                             mvn test -P weather-service
                      """
                    }
      }
      stage('Notification') {
         steps {
               script {
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
