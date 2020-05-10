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
   }
}
