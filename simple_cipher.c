#include <stdio.h>
#include <string.h>

int main() {
    char str[100];         // mutable buffer
    char *s[] = {str};     // array of char pointers
    int i;
    char c;

    printf("Enter a string: ");
    scanf("%99s", s[0]);

    printf("Enter a digit index: ");
    scanf("%d", &i);

    printf("Enter a bitwise op (&, ^, |): ");
    scanf(" %c", &c); // space before %c to skip newline

    switch (c) {
        case '&':
            while (1) {
                s[0][i] = s[0][i] & i;
                if (i == 9)
                    break;
                i++;
            }
            break;

        case '^':
            while (1) {
                s[0][i] = s[0][i] ^ i;
                if (i == 9)
                    break;
                i++;
            }
            break;

        case '|':
            while (1) {
                s[0][i] = s[0][i] | i;
                if (i == 9)
                    break;
                i++;
            }
            break;

        default:
            printf("Invalid operator!\n");
    }

    printf("After logical op = %s\n", s[0]);
    return 0;
}
