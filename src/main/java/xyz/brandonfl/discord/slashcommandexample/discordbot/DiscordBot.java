package xyz.brandonfl.discord.slashcommandexample.discordbot;

import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.brandonfl.discord.slashcommandexample.config.BotProperties;
import xyz.brandonfl.discord.slashcommandexample.discordbot.command.old.PingOldCommand;
import xyz.brandonfl.discord.slashcommandexample.discordbot.command.slash.PingSlashCommand;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DiscordBot {

  public final BotProperties botProperties;

  @PostConstruct
  public void startBot() throws LoginException {
    EventWaiter eventWaiter = new EventWaiter();
    // start getting a bot account set up

    CommandClientBuilder commandClientBuilder = new CommandClientBuilder();
    commandClientBuilder
        .setOwnerId(botProperties.getSetting().getOwnerId())
        .setCoOwnerIds(botProperties.getSetting().getCoOwnerIds().split(","))
        .setAlternativePrefix("/")
        .setEmojis("\u2705", "\u26A0\uFE0F", "\u274C")
        .addCommands(
            new PingOldCommand()
        );

    if (botProperties.getSetting().getGuidDevelopmentId() != null) {
      log.warn("Force guild active. This setting is for development only.");
      commandClientBuilder.forceGuildOnly(botProperties.getSetting().getGuidDevelopmentId());
    }

    commandClientBuilder.addSlashCommands(
        new PingSlashCommand()
    );

    JDABuilder
        .create(
            GatewayIntent.GUILD_MESSAGES, // Used to get commands as messages
            GatewayIntent.DIRECT_MESSAGES) // Used to allow some commands by direct messages
        .setToken(botProperties.getSetting().getToken())
        .setAutoReconnect(true)
        .addEventListeners(
            eventWaiter,
            commandClientBuilder.build())
        .build();
  }
}
