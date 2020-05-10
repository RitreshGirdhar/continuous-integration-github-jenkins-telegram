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
               checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[url: 'https://github.com/RitreshGirdhar/microservice-deployment-ansible-jenkinsfile.git']], branches: [[name: 'origin/master']]], poll: false
        }
      }
   }
}
