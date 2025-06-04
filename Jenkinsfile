pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat '''
                    mvn clean
                    echo "Build ready"
                '''
            }
        }

        stage('Test') {
            steps {
                bat '''
                    mvn test
                    echo "Tests run successfully"
                '''
            }
        }

        stage('Deploy') {
            steps {
                bat 'echo "Ready for deployment"'
            }
        }
    }
}
