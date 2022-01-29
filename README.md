
<h1 align="center">
  <a href="https://github.com/brandonfl/discord-slash-command-example"><img src="https://github.com/brandonfl/discord-slash-command-example/blob/assets/discord-slash-command.png?raw=true" width="400"/></a>
  <br>
  <a href="https://github.com/brandonfl/discord-slash-command-example">Discord slash command example</a>
  <br>
</h1>
<h4 align="center"> Example of discord slash command using JPA </h4>

<p align="center">
  <a href="https://github.com/brandonfl/discord-slash-command-example/actions/workflows/sonar.yml"><img src="https://github.com/brandonfl/discord-slash-command-example/actions/workflows/sonar.yml/badge.svg" alt="github-sonar"></a>
  <a href="https://sonarcloud.io/summary/new_code?id=brandonfl_discord-slash-command-example"><img src="https://sonarcloud.io/api/project_badges/measure?project=brandonfl_discord-slash-command-example&metric=alert_status" alt="sonar-gate"></a>
  <a href="https://github.com/brandonfl/discord-slash-command-example/blob/master/LICENSE"><img src="https://img.shields.io/github/license/brandonfl/discord-slash-command-example" alt="licence"></a>
</p>

<p align="center">
  <a href="#how-to-use">How to use</a> •
  <a href="#variables">Variables</a> •
  <a href="#licence">Licence</a> 
</p>


## How to use
#### Use with java
1. Compile `mvn clean package`
2. Run `java -jar target/bot.war` with <a href="#variables">variables</a>

#### Use with tomcat
1. Compile `mvn clean package` and get the war file in `target`folder
2. Config the config file of your bot `CATALINA-HOME/conf/Catalina/localhost/bot.xml` with <a href="#variables">variables</a>
3. Deploy the war `CATALINA-HOME/webapps/bot.war`

## Variables

| Key | Description | Default |
|--|--|--|
| LOG_FILE | Location of log file | ./log/bot.log |
| BOT_TOKEN | Token of the Discord bot | None - **required** |
| BOT_SETTING_GUID_DEVELOPMENT_ID | For development only: Upserting commands to a specific server will update the commands cache instantly, instead of taking up to an hour on global commands. | None |
| BOT_OWNER_ID | Discord bot owner | 226715707017134080 - **required** |
| BOT_CO_OWNER_ID | Discord bot co-owners (separated by a comma) | None |

## Licence

Project under [MIT](https://github.com/brandonfl/discord-slash-command-example/blob/master/LICENSE) licence
