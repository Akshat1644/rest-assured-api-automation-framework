
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Validate Project') {
            steps {
                bat 'if not exist pom.xml exit /b 1'
                bat 'if not exist Jenkinsfile exit /b 1'
                echo 'Required project files are present.'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

	post {
	    always {
	        junit 'target/surefire-reports/TEST-*.xml'
	
	        archiveArtifacts(
	            artifacts: 'target/surefire-reports/**',
	            allowEmptyArchive: true
	        )
	
	        echo 'Jenkins pipeline execution completed.'
	    }
	
	    success {
	        echo 'API automation tests completed successfully!'
	       	emailext(
	            subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
	            body: """
	                <h2>Build Successful</h2>
	                <p>Job: ${env.JOB_NAME}</p>
	                <p>Build: #${env.BUILD_NUMBER}</p>
	                <p>All API automation tests passed.</p>
	                <p><a href="${env.BUILD_URL}">View Build Details</a></p>
	            """,
	            to: 'akshatdahalwar1234@gmail.com'
	        )
	    }
	
	    failure {
	        echo 'Build or API automation tests failed. Check the console output.'
	        emailext(
	            subject: "FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
	            body: """
	                <h2>Build Failed</h2>
	                <p>Job: ${env.JOB_NAME}</p>
	                <p>Build: #${env.BUILD_NUMBER}</p>
	                <p>Please inspect the console output and test reports.</p>
	                <p><a href="${env.BUILD_URL}console">View Console Output</a></p>
	            """,
	            to: 'akshatdahalwar1234@gmail.com'
	        )
	    }
	}

}
