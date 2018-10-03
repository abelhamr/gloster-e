if [ ${TRAVIS_PULL_REQUEST} = 'false' ] && [[ $TRAVIS_BRANCH = 'master'  ||  ${TRAVIS_BRANCH} = 'develop' ]]; then
      echo 'Checking Quality Gates'
      mvn -B clean verify sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=d9d4bfd1b8c2cbbb223457adc37d73e78ad168da -Dsonar.projectKey=gloster-e -Dsonar.organization=marocraft 
elif [ ${TRAVIS_PULL_REQUEST} != 'false' ]; then
      echo 'Build and analyze pull request'
      mvn -B clean verify sonar:sonar -Dsonar.host.url=https://sonarcloud.io  -Dsonar.projectKey=gloster-e -Dsonar.organization=marocraft  -Dsonar.login=9d4bfd1b8c2cbbb223457adc37d73e78ad168da -Dsonar.github.oauth= 87c1aa5b6ae95f5937e5b4562f636c4d512737af -Dsonar.pullrequest.github.repository=marocraft/gloster-e -Dsonar.pullrequest.provider=GitHub  -Dsonar.pullrequest.branch=${TRAVIS_BRANCH}  -Dsonar.pullrequest.key=${TRAVIS_PULL_REQUEST};
fi