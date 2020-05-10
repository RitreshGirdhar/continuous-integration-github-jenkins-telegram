pipeline {
   agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
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
      stage ('Initialize') {
                  steps {
                      sh '''
                          echo "PATH = ${PATH}"
                          echo "M2_HOME = ${M2_HOME}"
                      '''
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
                            sh """
                                    mvn clean install
                            """
                  }
      }
   }
}
