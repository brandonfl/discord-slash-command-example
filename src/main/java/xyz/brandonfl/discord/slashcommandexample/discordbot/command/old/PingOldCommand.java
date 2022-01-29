package xyz.brandonfl.discord.slashcommandexample.discordbot.command.old;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

@Deprecated
public class PingOldCommand extends Command {

  public PingOldCommand() {
    this.name = "ping";
    this.help = "Get bot ping.";
    this.guildOnly = false;
    this.cooldown = 60;
  }

  @Override
  protected void execute(CommandEvent event) {
    long time = System.currentTimeMillis();
    event.getChannel().sendMessage("Pong!") /* => RestAction<Message> */
        .queue(response /* => Message */ -> {
          response.editMessageFormat("Pong: %d ms", System.currentTimeMillis() - time).queue();
        });
  }
}