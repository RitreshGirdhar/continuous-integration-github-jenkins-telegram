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
      stage('dir change') {
         steps {
           sh """ 
              cd /var/jenkins_home/workspace/sensible/     
              pwd
              ls -lrt
           """ 
         }
      }
      
      stage('Ansible') {
         steps {
            ansiblePlaybook('ansible-deployment/deploy.yml') {
              inventoryPath('ansible-deployment/hosts')
              ansibleName('Test')
              credentialsId('ansible_vault_credentials')
              become(true)
              becomeUser("user")
              extraVars {
                   
              }
            }
         }
      } 
   }
}
