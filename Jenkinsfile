node{


try{
    stage('Git checkout'){
        git credentialsId: 'amodak', url: 'https://github.com/avishekdevops/springboot_app_bootcamp.git'
    }
    stage('Build & Test'){
        def mavenHome = tool name: 'maven-3', type: 'maven'
        def mavenCMD = "${mavenHome}/bin/mvn"

        sh "${mavenCMD} clean package"
    }
    
    stage('Build Docker Image'){
        def dockerHome = tool name: 'mydocker', type: 'dockerTool'
        def dockerCMD = "${dockerHome}/bin/docker"
        sh "echo ${dockerHome}"
       
       sh "${dockerCMD} build -t amodak/springapp:1.0 ."
    }
    
    stage('Push Docker Image to DockerHub'){
        withCredentials([string(credentialsId: 'docpasswd', variable: 'dockerPWD')]){
        sh "docker login -u amodak -p ${dockerPWD}"
        sh 'docker push amodak/springapp:1.0'
        }
    }
    
    stage('Provision EC2 Instance for Docker'){
        sh 'pip list|grep boto'
       ansiblePlaybook becomeUser: 'ubuntu', credentialsId: 'ec2-login', playbook: '/home/ubuntu/git_sprintboot/Junit-Test/playbook.yml', sudoUser: 'ubuntu'
       sleep(60)
    }
    
    stage('Installation of Docker in new provisioned EC2 Instance'){
        def cliCommand = 'aws ec2 describe-instances --query "Reservations[*].Instances[*].PublicIpAddress[]" --region us-east-2'
        def output = sh script: "${cliCommand}" , returnStdout:true
        def ipList = output.split('"')
        ipAddress=ipList[1]
        println ipAddress
 
        sh "echo ${ipAddress}"
        sshagent(['devOps-key']) {
	    def update = 'sudo apt-get update' 
	    def dockerInstall = 'sudo apt install docker.io -y'
        def dockerVersion = 'docker --version'
        def dockerStart = 'sudo systemctl start docker'
        def dockerrun = 'sudo docker run -p 8082:8082 -d amodak/springapp:1.0'

        sh "ssh -o StrictHostKeyChecking=no ubuntu@${ipAddress} ${update}"
        sh "ssh -o StrictHostKeyChecking=no ubuntu@${ipAddress} ${dockerInstall}"
        sh "ssh -o StrictHostKeyChecking=no ubuntu@${ipAddress} ${dockerVersion}"
        sh "ssh -o StrictHostKeyChecking=no ubuntu@${ipAddress} ${dockerStart}"
        sh "ssh -o StrictHostKeyChecking=no ubuntu@${ipAddress} ${dockerrun}"
        
        }
    }
}
catch(e)
{
emailext attachLog: true, body: "Jenkin Job Failed: Job ${env.JOB_NAME}: Build ${env.BUILD_NUMBER}: Log ${env.BUILD_LOG_EXCERPT}.Check console output at ${env.BUILD_URL}", subject: "Jenkins Job Failed: Job ${env.JOB_NAME}: Build ${env.BUILD_NUMBER}", to: 'aviaws2020@gmail.com', from: 'Jenkinsserver<aviaws2020@gmail.com>'
throw e
}
}
