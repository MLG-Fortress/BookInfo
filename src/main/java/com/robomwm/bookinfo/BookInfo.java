package com.robomwm.bookinfo;

import de.themoep.minedown.MineDown;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 5/12/2018.
 *
 * @author RoboMWM
 */
public class BookInfo extends JavaPlugin
{
    public void onEnable()
    {
        if (getConfig().getKeys(false).size() == 0)
        {
            List<String> test = new ArrayList<>();
            test.add("Default text");
            test.add("&5Supports &acolors");
            getConfig().addDefault("test", test);
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (args.length < 1)
            return false;

        reloadConfig();
        String bookTitle = String.join(" ", args);
        return true;
    }

    private ItemStack getBook(List<String> content)
    {
        if (content == null)
            return null;
        BookMeta book = LazyText.getBookMeta();
        for (String text : content)
        {
            new MineDown(text).toComponent()
        }
    }
}
