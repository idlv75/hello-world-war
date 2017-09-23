mavenJob('MavenCI') {
	logRotator (-1,10)
	scm {
        github('idlv75/hello-world-war')
    }
	trigers{
		githubPush()
	}
	goals('clean install')
	wrappers {
        mavenRelease {
            scmUserEnvVar('MY_USER_ENV')
            scmPasswordEnvVar('MY_PASSWORD_ENV')
            releaseEnvVar('RELEASE_ENV')
            releaseGoals('-B clean release:clean release:prepare release:perform')
            dryRunGoals('-DdryRun=true -B release:prepare')
            selectCustomScmCommentPrefix()
            selectAppendJenkinsUsername()
            selectScmCredentials()
            numberOfReleaseBuildsToKeep(10)
        }
    }
}