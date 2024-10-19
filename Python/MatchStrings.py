def stringMatch() -> bool:
    text = str(input("Input the main string: "))
    matching = str(input("Input the string to seek for a match: "))
    if len(text) < len(matching):
        raise ValueError("The string to match shall be smaller than the original string!")
    for i in range(0, len(text) - len(matching) + 1):
        if(text[i:len(matching)+i] == matching):
            return True
    return False

if __name__ == '__main__':
    result = stringMatch()
    if result:
        print("Matched!")
    else:
        print("No match!")
