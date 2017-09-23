	mavenJob('MavenCI') {
		logRotator (-1,10)
		triggers { scm('H/15 * * * *') }
		trigers {
			githubPush()
		}
		scm {
			git {
				remote {
					github('idlv75/hello-world-war')
					credentials('github-jenkins-PK')
					extensions {
						wipeOutWorkspace()
						localBranch('master')
					}
				}
			}
		}
		goals('clean install')
		wrappers {
			preBuildCleanup()
			mavenRelease {
				releaseGoals('clean release:clean release:prepare release:perform')
				dryRunGoals('-DdryRun=true 	release:prepare')
				numberOfReleaseBuildsToKeep(10)
			}
		}
	}