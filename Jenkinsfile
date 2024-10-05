pipeline {
    agent any
    
    tools {
        maven 'Maven 3.x'  // Ensure this matches the Maven installation name in Jenkins
    }
    

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/daksh03/SpringBoot-App.git', branch: 'main'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean package' // Use 'bat' instead of 'sh' if running on Windows
            }
        }
        

        stage('Deploy to Tomcat') {
            steps {
                // Escape backslashes for Windows paths
                bat 'copy target\\*.war "C:\\Program Files\\Apache Software Foundation\\Tomcat 10.1\\webapps\\"'
            }
        }
        
    }
}
