import discord
import random
from discord.ext import commands

bot = commands.Bot(command_prefix=".")


@bot.event
async def on_ready():
    print("Let's get started!")


@bot.command()
async def hello(ctx):
    await ctx.reply('Hello!')


@bot.command()
async def rps(ctx, message):
    answer = message.lower()
    choice = ["rock", "paper", "scissors"]
    computers_answer = random.choice(choice)
    if answer not in choice:
        await ctx.reply("This is not a valid choice. Choose one of these: rock, paper, scissors.")
    else:
        if computers_answer == answer:
            await ctx.reply("It's a tie :/.")
        if computers_answer == "rock":
            if answer == "paper":
                await ctx.reply(f"You win! I chose {computers_answer} and you chose {answer}!")
        if computers_answer == "rock":
            if answer == "scissors":
                await ctx.reply(f"You loose! I chose {computers_answer} and you chose {answer}!")
        if computers_answer == "paper":
            if answer == "rock":
                await ctx.reply(f"You loose! I chose {computers_answer} and you chose {answer}!")
        if computers_answer == "paper":
            if answer == "scissors":
                await ctx.reply(f"You win! I chose {computers_answer} and you chose {answer}!")
        if computers_answer == "scissors":
            if answer == "rock":
                await ctx.reply(f"You win! I chose {computers_answer} and you chose {answer}!")
        if computers_answer == "scissors":
            if answer == "paper":
                await ctx.reply(f"You loose! I chose {computers_answer} and you chose {answer}!")

bot.run('OTMwMzU2NDk4NjAzODQ3NzMw.Yd0sAg.hD8J5UTjQ58XoPB36YW83Z-LnV8')
